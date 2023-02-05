package com.swayy.core_database.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.swayy.core_database.local.AppDatabase
import com.swayy.core_database.local.Converters
import com.swayy.core_database.local.SmsHelper
import com.swayy.core_database.repository.MessagesRepository
import com.swayy.core_database.repository.MessagesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideConverters() = Converters()

    @Provides
    @Singleton
    fun smsHelper(@ApplicationContext context : Context):SmsHelper {
        return SmsHelper(context)
    }


    @Provides
    @Singleton
    fun provideMpesaDatabase(
        @ApplicationContext context: Context,
        converters: Converters
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "ledger-db"
        )
            .addTypeConverter(converters)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMessageRepository(
        smsHelper: SmsHelper,
        livescoreDatabase: AppDatabase
    ): MessagesRepository {
        return MessagesRepositoryImpl(
            smsHelper = smsHelper,
            messagesDao = livescoreDatabase.messagesDao(),
        )
    }


}