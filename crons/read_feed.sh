#!/bin/bash
# Takes in one long news feed and one short feed, isolates the mp3s, and plays them

export PATH=$PATH:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/local/games:/usr/games

insecurehttp="http:"
securehttp="https:"

# Get long podcast
longcast=$(shuf -n 1 ./longcastlist.txt)

longrssaddy=$(wget -qO- $longcast |\
grep -o -m 1 -P '(?<=<enclosure url=")[^"?]*')

longrssaddy=$(echo $longrssaddy | sed "s/$insecurehttp/$securehttp/g")

# Get short podcast
shortcast=$(shuf -n 1 ./shortcastlist.txt)

shortrssaddy=$(wget -qO- $shortcast |\
grep -o -m 1 -P '(?<=<enclosure url=")[^"?]*')

shortrssaddy=$(echo $shortrssaddy | sed "s/$insecurehttp/$securehttp/g")

# Play one, read the weather, then play the other
mplayer $longrssaddy

./scripts/temperature.sh

espeak "And now for something completely different. ." 2>/dev/null

mplayer $shortrssaddy
