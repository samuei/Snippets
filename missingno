# missingno finds the missing entry in an arithmetic sequence of integers
def missingno():
    rawlist = raw_input("List of elements, separated by spaces: ")
    list = []
    for i in rawlist:
        if i != " ":
            list.append(int(i))
    diff = list[1] - list[0]
    for index in range(2,len(list)):
        localdiff = (list[index] - list[index-1])
        if diff > localdiff:
            return list[0] + localdiff
        if diff < localdiff:
            return list[index-1]+diff
