'''
    Script that modifies the original dataset to a new minimized dataset that is unique for this project
'''

import re

array_list = []

# Extract the amazonmetadata from https://snap.stanford.edu/data/amazon-meta.html, then rename the extracted text file to amazonmeta.txt
with open('amazonmeta.txt', encoding="utf-8") as f:
    for line in f:
        temp = line.strip()
        if re.match(r'(?=.*\bASIN\b|\btitle\b|\bgroup\b|\bsimilar\b)', temp):
            array_list.append(temp)
        elif re.match(r'(?=.*\breviews\b)', temp):
            rateIndex = temp.index('avg rating:')
            tempslice = temp[rateIndex:]
            array_list.append(tempslice)

indexasin = []

for i in range(len(array_list)):    
    if re.match(r'(?=.*\bASIN\b)', array_list[i]):
       indexasin.append(i)

combined = []
strings = []

for i in range(len(indexasin) - 1):
    combined.append(array_list[indexasin[i] : indexasin[i + 1]])
combined.append(array_list[indexasin[-1]:])

for i in combined:
    if(len(i) == 5):
        strings.append(', '.join(i) + "\n")

# Creates a new preprocessed text file
outF = open("productdata2.txt", "w", encoding="utf-8")
for line in strings:
  outF.write(line)
outF.close()