
from collections import Counter
import PySimpleGUI as sg
import os.path

# function to display the words occurences results
def show_results(lst):

    lay = [
        [sg.Multiline(lst, size=(70,20)),],
    ]

    win = sg.Window("Results", lay, modal=True, finalize=True)

    while True:
        event, values = win.read()
        if event == sg.WINDOW_CLOSED:
            break
    
    win.close()

file_list_column = [
    [
        sg.Text("Words Folder"),
        sg.In(size=(30,1), enable_events=True, key="-FOLDER-"),
        sg.FolderBrowse(),
    ],
    [
        sg.Listbox(
            values=[], enable_events=True, size=(40,20),
            key="-FILE LIST-"
        )
    ],
]

words_count_column = [
    [sg.Text("Choose a file from the list:")],
    [sg.Text(size=(40,1), key="-TOUT-")],
    [sg.Image(key="-IMAGE-")],
    [sg.Button("Count words occurences in selected file")]
]

# create a layout
layout = [
    [sg.Text("Hello there! This is the Word Occurences App written by Son Vu")],
    [
        sg.Column(file_list_column),
        sg.VSeparator(),
        sg.Column(words_count_column),
    ],
    [sg.Button("Close the app")],
]

window = sg.Window('Words Occurences App', layout, margins=(80,40))

# count words occurences function
def count_words_occurences(filename):   
    textHolder = []

    with open(filename, encoding="utf8") as file:
        reader = file.read()
        word_split = reader.split(" ")
        for w in word_split:
            textHolder.append(w)
    file.close()

    counter = Counter(textHolder)

    results = counter.most_common(20)

    show_results(results)
    return results

# create an event loop
while True:
    event, values = window.read()
    if event == "Close the app" or event == sg.WIN_CLOSED:
        break
    if event == "-FOLDER-":
        folder = values["-FOLDER-"]
        try:
            file_list = os.listdir(folder)
        except:
            file_list = []

        fnames = [
            f
            for f in file_list
            if os.path.isfile(os.path.join(folder, f))
            and f.lower().endswith((".txt"))
        ]
        window["-FILE LIST-"].update(fnames)
    elif event == "-FILE LIST-": # if a file is chosen from the list
        try:
            filename = os.path.join(
                values["-FOLDER-"], values["-FILE LIST-"][0]
            )
            window["-TOUT-"].update(filename)
        except:
            pass
    elif event == "Count words occurences in selected file":
        count_words_occurences(filename)

window.close()

