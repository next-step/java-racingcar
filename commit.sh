#!/bin/bash
# commit <subject>

function select_option {

    # little helpers for terminal print control and key input
    ESC=$( printf "\033")
    cursor_blink_on()  { printf "$ESC[?25h"; }
    cursor_blink_off() { printf "$ESC[?25l"; }
    cursor_to()        { printf "$ESC[$1;${2:-1}H"; }
    print_option()     { printf "    $1 "; }
    print_selected()   { printf " ✔ $ESC[7m $1 $ESC[27m"; }
    get_cursor_row()   { IFS=';' read -sdR -p $'\E[6n' ROW COL; echo ${ROW#*[}; }
    key_input()        { read -s -n3 key 2>/dev/null >&2
                         if [[ $key = $ESC[A ]]; then echo up;    fi
                         if [[ $key = $ESC[B ]]; then echo down;  fi
                         if [[ $key = ""     ]]; then echo enter; fi; }

    # initially print empty new lines (scroll down if at bottom of screen)
    for opt; do printf "\n"; done

    # determine current screen position for overwriting the options
    local lastrow=`get_cursor_row`
    local startrow=$(($lastrow - $#))

    # ensure cursor and input echoing back on upon a ctrl+c during read -s
    trap "cursor_blink_on; stty echo; printf '\n'; exit" 2
    cursor_blink_off

    local selected=0
    while true; do
        # print options by overwriting the last lines
        local idx=0
        for opt; do
            cursor_to $(($startrow + $idx))
            if [ $idx -eq $selected ]; then
                print_selected "$opt"
            else
                print_option "$opt"
            fi
            ((idx++))
        done

        # user key control
        case `key_input` in
            enter) break;;
            up)    ((selected--));
                   if [ $selected -lt 0 ]; then selected=$(($# - 1)); fi;;
            down)  ((selected++));
                   if [ $selected -ge $# ]; then selected=0; fi;;
        esac
    done

    # cursor position back to normal
    cursor_to $lastrow
    printf "\n"
    cursor_blink_on

    return $selected
}

function commit {
    subject=$1
    echo "[✏] type : "
    types=("feat" "fix" "docs" "style" "refactor" "test" "chore")

    select_option "${types[@]}"
    type=${types[$?]}
    read -p "[✏] scope > " scope
    echo "${type}(${scope}): ${subject}"
    echo "[✏] select editor for write body : "
    editors=("this" "vscode" "vi" "vim" "nano" "gedit")
    select_option "${editors[@]}"
    editor=${editors[$?]}

    tmpFileName=".tmpCommitMsg-$RANDOM"

    echo "${type}(${scope}): ${subject}" > ${tmpFileName}
    echo "" >> ${tmpFileName}
    case $editor in
    "vscode") 
        code -w ${tmpFileName}
        ;;
    "vi") 
        vi ${tmpFileName}
        ;;
    "vim") 
        vim + ${tmpFileName}
        ;;
    "nano") 
        nano ${tmpFileName}
        ;;
    "gedit") 
        gedit ${tmpFileName}
        ;;
    *)
        echo "write body (^D (ctrl + D) for submit) >"
        body=$(</dev/stdin)
        for line in $body
        do
            echo $line >> ${tmpFileName}
        done
        ;;
    esac
    git commit -F ${tmpFileName}
    rm ${tmpFileName}
    echo "[😏] done!"
}

IFS=$'\n'

if [ $# == 1 ]
then
    commit $1
else
    read -p "[✏] subject > " subject
    commit $subject
fi
