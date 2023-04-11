package com.laioffer.tinnews.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.laioffer.tinnews.model.Article;
import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.repository.NewsRepository;

//view model 的作用，接受user的UI event, 调用后端 convert user UI event to the real UI
public class HomeViewModel extends ViewModel {

    private final NewsRepository repository;
    private final MutableLiveData<String> countryInput = new MutableLiveData<>();

    public HomeViewModel(NewsRepository newsRepository) {
        this.repository = newsRepository;
    }

    public void setCountryInput(String country) {
        countryInput.setValue(country);
    }

    public LiveData<NewsResponse> getTopHeadlines() {
        // switchMap is to 把一种format转换为另一种format,这里将user input 转化为 NewsResponse
        return Transformations.switchMap(countryInput, repository::getTopHeadlines);
    }
    public void setFavoriteArticleInput(Article article) {
        repository.favoriteArticle(article);
    }
}