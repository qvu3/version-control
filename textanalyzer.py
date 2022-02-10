from collections import Counter

textHolder = []

with open(r"C:\Users\VQHSon\Desktop\Poem.txt", encoding="utf8") as file:
    reader = file.read()
    word_split = reader.split(" ")
    for w in word_split:
        textHolder.append(w)
file.close()

counter = Counter(textHolder)

print(dict(counter.most_common(20)))
