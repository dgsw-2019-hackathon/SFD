from django.db import models

class Fire(models.Model):
    receive = models.BooleanField()
    longitude = models.TextField()
    latitude = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)

class BigFire(models.Model):
    receive = models.BooleanField()
    longitude = models.TextField()
    latitude = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)

class Earthquake(models.Model):
    receive = models.BooleanField()
    intensity = models.TextField()
    longitude = models.TextField()
    latitude = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)

class Storm(models.Model):
    receive = models.BooleanField()
    longitude = models.TextField()
    latitude = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)


class News(models.Model):
    title = models.TextField()
    content = models.TextField()
    longitude = models.TextField()
    latitude = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)

class Run(models.Model):
    name = models.TextField()
    content = models.TextField()
    longitude = models.TextField()
    latitude = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)

class Rescue(models.Model):
    receive = models.BooleanField()
    longitude = models.TextField()
    latitude = models.TextField()
    create_at = models.DateTimeField(auto_now_add=True)
