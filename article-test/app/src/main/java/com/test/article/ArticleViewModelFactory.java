package com.test.article;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ArticleViewModelFactory implements ViewModelProvider.Factory {
    private Application application;
    private int id;


    public ArticleViewModelFactory(Application application, int id) {
        this.application = application;
        this.id = id;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ArticleDetailViewModel(application, id);
    }
}
