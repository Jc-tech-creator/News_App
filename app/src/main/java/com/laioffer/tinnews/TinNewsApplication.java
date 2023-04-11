package com.laioffer.tinnews;

import android.app.Application;
import android.os.AsyncTask;

import androidx.room.Room;

import com.laioffer.tinnews.database.TinNewsDatabase;
import com.laioffer.tinnews.model.Article;

import java.util.UUID;

public class TinNewsApplication extends Application {
    private static TinNewsDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        database = Room.databaseBuilder(this, TinNewsDatabase.class, "tinnews_db").build();
//        Article article = new Article();
//        article.url = UUID.randomUUID().toString();
//        AsyncTask.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("enter into run");
//                database.articleDao().saveArticle(article);
//            }
//        });
    }

    public static TinNewsDatabase getDatabase() {
        return database;
    }

}




