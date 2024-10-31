package com.example.mvpproject.di.modules;

import android.content.Context;

import com.chuckerteam.chucker.api.ChuckerInterceptor;
import com.example.mvpproject.network.ApiClient;
import com.example.mvpproject.network.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class CoreModule {

    private Context mContext;

    public CoreModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor) // Add the logging interceptor
                .addInterceptor(new ChuckerInterceptor(mContext))
                .build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl("https://api.restful-api.dev")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // Add the RxJava3 call adapter
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    @Provides
    ApiClient provideClient(ApiService apiService) {
        return new ApiClient(apiService);
    }

}
