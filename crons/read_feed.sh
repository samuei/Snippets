#!/bin/bash
# Takes NPR news hour feed, isolates the mp3, and plays it

rssaddy=$(wget -qO- "https://www.npr.org/rss/podcast.php?id=500005" |\
grep -o '<enclosure url="[^?]*' |\
grep -o '[^"]*$')

mplayer $rssaddy
