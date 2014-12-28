# I realize using random is sort of cheating, but since random's implementation
# calls urandom, we're all cheaters in here.
from random import randint

def diceroll(numrolls,numsides):
	results = []
	# numrolls can be whatever, but numsides gets picky. Gotta sanitize:
	if numsides == 0 or type(numsides) is not int:
		return results
	seed = (randint(1,255) + numrolls)*numsides
	# I'm gonna use a weird variation on the middle-square method because I'm
	# not a proper cryptographer
	for cur in range(numrolls):
		result =  seed * seed
		result = result + cur
		result = (int(str(result).zfill(8)[2:6]))
		results.append((result%numsides) + 1)
		seed = result + cur
	return results

def creationdice():
	# Roll 4d6
	results = diceroll(4,6)
	results.sort()
	# Drop lowest, return total
	return sum(results[1:])
	
def distributiontest(numtrials, numsides):
	# No running "Zzyzzyxx" number of trials.
	if type(numtrials) is not int:
		return;
	if numsides == 0 or type(numsides) is not int:
		return;
	data = diceroll(numtrials,numsides)
	results = [0]*numsides
	for element in data:
		results[element-1] += 1;
	for idx, val in enumerate(results):
		print (idx+1),": ",val

def dicerollsum(numrolls,numsides):
	return sum(diceroll(numrolls,numsides))

