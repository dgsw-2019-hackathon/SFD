from django.http import Http404
from rest_framework import status
from rest_framework.response import Response
from rest_framework.views import APIView
from .models import  Fire, Earthquake, Storm ,News, Run, BigFire, Rescue
from .serializers import FireSerializer, EarthquakeSerializer ,StormSerializer ,NewsSerializer, RunSerializer, BigFireSerializer, RescueSerializer


class FireList(APIView):
    def post(self, request, format=None):
        serializer = FireSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def get(self, request, format=None):
        queryset = Fire.objects.last()
        serializer = FireSerializer(queryset, many=False)
        return Response(serializer.data)

class BigFireList(APIView):
    def post(self, request, format=None):
        serializer = BigFireSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def get(self, request, format=None):
        queryset = BigFire.objects.last()
        serializer = BigFireSerializer(queryset, many=False)
        return Response(serializer.data)

class EarthquakeList(APIView):
    def post(self, request, format=None):
        serializer = EarthquakeSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def get(self, request, format=None):
        queryset = Earthquake.objects.last()
        serializer = EarthquakeSerializer(queryset, many=False)
        return Response(serializer.data)

class StormList(APIView):
    def post(self, request, format=None):
        serializer = StormSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def get(self, request, format=None):
        queryset = Storm.objects.last()
        serializer = StormSerializer(queryset, many=False)
        return Response(serializer.data)

class RunList(APIView):
    def post(self, request, format=None):
        serializer = RunSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def get(self, request, format=None):
        queryset = Run.objects.all().order_by('-create_at')[:10]
        serializer = RunSerializer(queryset, many=True)
        return Response(serializer.data)

class RunDetail(APIView):
    def get_object(self, pk):
        try:
            return Run.objects.get(pk=pk)
        except Run.DoesNotExist:
            raise Http404
    def get(self, request, pk):
        post = self.get_object(pk)
        serializer = RunSerializer(post)
        return Response(serializer.data)

    def put(self, request, pk, format=None):
        post = self.get_object(pk)
        serializer = RunSerializer(post, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.error, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, HTTP_400_BAD_REQUEST, pk, format=None):
        post = self.get_object(pk)
        post.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

class NewsList(APIView):
    def post(self, request, format=None):
        serializer = NewsSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def get(self, request, format=None):
        queryset = News.objects.all().order_by('-create_at')[:4]
        serializer = NewsSerializer(queryset, many=True)
        return Response(serializer.data)

class NewsDetail(APIView):
    def get_object(self, pk):
        try:
            return News.objects.get(pk=pk)
        except News.DoesNotExist:
            raise Http404
    def get(self, request, pk):
        post = self.get_object(pk)
        serializer = NewsSerializer(post)
        return Response(serializer.data)

    def put(self, request, pk, format=None):
        post = self.get_object(pk)
        serializer = NewsSerializer(post, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.error, status=status.HTTP_400_BAD_REQUEST)

    def delete(self, HTTP_400_BAD_REQUEST, pk, format=None):
        post = self.get_object(pk)
        post.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)

class RescueList(APIView):
    def post(self, request, format=None):
        serializer = RescueSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    def get(self, request, format=None):
        queryset = Rescue.objects.last()
        serializer = RescueSerializer(queryset, many=False)
        return Response(serializer.data)
