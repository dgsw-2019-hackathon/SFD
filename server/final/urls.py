from django.urls import path
from .import views

urlpatterns = [
    path('fire/', views.FireList.as_view()),
    path('bfire/', views.BigFireList.as_view()),
    path('earth/', views.EarthquakeList.as_view()),
    path('storm/', views.StormList.as_view()),
    path('run/', views.RunList.as_view()),
    path('run/<int:pk>/', views.RunDetail.as_view()),
    path('news/', views.NewsList.as_view()),
    path('news/<int:pk>/', views.NewsDetail.as_view()),
    path('rescue/', views.RescueList.as_view()),
]
