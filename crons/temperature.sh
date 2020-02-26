#!/bin/bash
# Tell me the local weather

currentTemp="$(weather klwc | awk '/Temperature/ { print $2}')"

outText="It is currently $currentTemp degrees Fahrenheit outside."

espeak "$outText" 2>/dev/null
