#1. Write the function that reverses a string without using explicit loops. E.g. “Hello” should return “olleH”.

# For Python 2.6+ users, comment out this line. Otherwise, keep it.
from __future__ import print_function

def StringRev(inString):
    if(len(inString)>0):
        print(inString[len(inString) -1:], end='')
        StringRev(inString[:-1])

#Test Input:
StringRev("Hello, Darkness, my old friend")
print()
StringRev("I've come to talk with you again")

#Test Output:
#dneirf dlo ym ,ssenkraD ,olleH
#niaga uoy htiw klat ot emoc ev'I 
