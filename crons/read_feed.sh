#!/bin/bash
# Takes in one long news feed and one short feed, isolates the mp3s, and plays them. Also gives me the weather.

export PATH=$PATH:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/local/games:/usr/games

# Get long podcast
longcast=$(shuf -n 1 ./longcastlist.txt)

longrssaddy=$(wget -qO- $longcast |\
grep -o -m 1 -P '(?<=<enclosure url=")[^"?]*')

# Get short podcast
shortcast=$(shuf -n 1 ./shortcastlist.txt)

shortrssaddy=$(wget -qO- $shortcast |\
grep -o -m 1 -P '(?<=<enclosure url=")[^"?]*')

# Play one, read the weather, then play the other
mplayer $longrssaddy

./scripts/temperature.sh

espeak "And now for something completely different. ." 2>/dev/null

mplayer $shortrssaddy
