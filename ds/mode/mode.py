# Inspired by Chris O'Brien who used python to check
# modulo for the Mancala game.
# The voting bins idea is from Mike Zamansky

import random

numPatronsList = list()

maxNumPatrons = 20

for count in range(40):
    value = random.randint(1,maxNumPatrons)
    numPatronsList.append(value)

#numbers of patrons over a period of days
print(numPatronsList)

# Return the frequency (count of the value in a list) of value
def frequency(value):
    count = 0
    for num in numPatronsList:
        if value == num:
            count = count + 1
        #print(count)
    return count

# test out the frequency
#print(frequency(numPatronsList[0]))

def mode():
    mode = numPatronsList[0]
    modeCount = frequency(mode)
    for num in numPatronsList:
        if modeCount < frequency(num):
            mode = num
            modeCount = frequency(num)
    print('SlowMode: frequency of %d is %d' % (mode, frequency(mode)) )
    return mode

def fastMode():
    binList = list()
    for count in range(maxNumPatrons):
        binList.append(0)
    for num in numPatronsList:
        binList[num-1] = binList[num-1] + 1
    index = 0
    mode = index
    modeCount = binList[mode]
    while index < len(binList):
        if modeCount < binList[index]:
            modeCount = binList[index] # frequency for the num
            mode = index # num, but actually value is equal to Num - 1
        index = index + 1
    realMode = mode + 1
    print('frequency of %d is %d' % (realMode, modeCount ))
    return realMode  # The index is one less than the actual Number


print(mode())
print(fastMode())
