import RPi.GPIO as GPIO
import time
import requests
import json
GPIO.setwarnings(False)
Fireurl = 'http://192.168.137.221:1278/api2/fire/'
BFireurl = 'http://192.168.137.221:1278/api2/bfire/'
Earthurl = 'http://192.168.137.221:1278/api2/earth/'
Cycloneurl = 'http://192.168.137.221:1278/api2/storm/'
GETURL = 'http://192.168.137.221:1278/api2/rescue/'
buzzer=21
fire=16
button1=2
button2=3
button3=4
GPIO.cleanup()
GPIO.setmode(GPIO.BCM)
GPIO.setup(buzzer,GPIO.OUT)
GPIO.setup(fire,GPIO.IN,pull_up_down=GPIO.PUD_UP)
GPIO.setup(button1,GPIO.IN,pull_up_down=GPIO.PUD_UP)
GPIO.setup(button2,GPIO.IN,pull_up_down=GPIO.PUD_UP)
GPIO.setup(button3,GPIO.IN,pull_up_down=GPIO.PUD_UP)
try:
	while True:
		if GPIO.input(fire)==0:
			print "FIRE"
			payload = {'receive':True, 'longitude':'35.871665', 'latitude':'128.601718'}
			r=requests.post(Fireurl,json=payload)
			print "fine"
		else:
			payload = {'receive':False, 'longitude':'37.871665', 'latitude':'128.601718'}
			r=requests.post(Fireurl,json=payload)
		
		if GPIO.input(button1)==0: 
			print "BIG FIRE"
			payload = {'receive':True, 'longitude':'37.871665', 'latitude':'128.601718'}
			r=requests.post(BFireurl,json=payload)
			print "fine"
		else:
			payload = {'receive':False, 'longitude':'37.871665', 'latitude':'128.601718'}
			r=requests.post(BFireurl,json=payload)
		if GPIO.input(button2)==0:
			print "EARTH"
			payload = {'receive':True, 'longitude':'37.871665', 'latitude':'128.601718' ,'intensity':'5.0'}
			r=requests.post(Earthurl,json=payload)
			print "fine"
		else:
			payload = {'receive':False, 'longitude':'37.871665', 'latitude':'128.601718','intensity':'0.0'}
			r=requests.post(Earthurl,json=payload)
		if GPIO.input(button3)==0:
			print "CYCLONE"
			payload = {'receive':True, 'longitude':'37.871665', 'latitude':'128.601718'}
			r=requests.post(Cycloneurl,json=payload)
			print "fine"
		else:
			payload = {'receive':False, 'longitude':'37.871665', 'latitude':'128.601718'}
			r=requests.post(Cycloneurl,json=payload)
		response = requests.get(GETURL)
		print response.status_code
		print response.text
		if response.text[19:23] == 'true':
			while True:
				response = requests.get(GETURL)
				print response.status_code
				print response.text
				if response.text[19:23] != 'true':
					break
				GPIO.output(buzzer,True)
				time.sleep(0.5)
				GPIO.output(buzzer,False)
		time.sleep(2)
except KeyboardInterrupt:
	GPIO.cleanup()


