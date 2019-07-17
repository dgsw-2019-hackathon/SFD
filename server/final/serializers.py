from rest_framework import serializers
from .models import Fire, Earthquake, Storm ,News, Run, BigFire, Rescue

class EarthquakeSerializer(serializers.ModelSerializer):
    class Meta:
        model = Earthquake
        fields = '__all__'

class FireSerializer(serializers.ModelSerializer):
    class Meta:
        model = Fire
        fields = '__all__'

class BigFireSerializer(serializers.ModelSerializer):
    class Meta:
        model = BigFire
        fields = '__all__'

class StormSerializer(serializers.ModelSerializer):
    class Meta:
        model = Storm
        fields = '__all__'

class NewsSerializer(serializers.ModelSerializer):
    class Meta:
        model = News
        fields = '__all__'

class RunSerializer(serializers.ModelSerializer):
    class Meta:
        model = Run
        fields = '__all__'

class RescueSerializer(serializers.ModelSerializer):
    class Meta:
        model = Rescue
        fields = '__all__'
