#!/usr/bin/env python3

import RPi.GPIO as GPIO
import signal                   
import subprocess
import sys
import time

BUTTON_GPIO = 16

def signal_handler(sig, frame):
	GPIO.cleanup()
	sys.exit(0)

def button_pressed_callback(channel):
	subprocess.call(['sh', './scripts/temperature.sh'])

if __name__ == '__main__':
	GPIO.setmode(GPIO.BCM)
	GPIO.setup(BUTTON_GPIO, GPIO.IN, pull_up_down=GPIO.PUD_UP)
	
	GPIO.add_event_detect(BUTTON_GPIO, GPIO.RISING, callback=button_pressed_callback, bouncetime=12000)
	
	signal.signal(signal.SIGINT, signal_handler)
	signal.pause()