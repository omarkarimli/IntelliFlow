package com.omarkarimli.intelliflow.di

import com.omarkarimli.intelliflow.data.repository.AuthRepositoryImpl
import com.omarkarimli.intelliflow.data.source.local.LocalDataSource
import com.omarkarimli.intelliflow.data.source.local.LocalDataSourceImpl
import com.omarkarimli.intelliflow.data.source.remote.RemoteDataSource
import com.omarkarimli.intelliflow.data.source.remote.RemoteDataSourceImpl
import com.omarkarimli.intelliflow.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ): RemoteDataSource

    @Binds
    @Singleton
    abstract fun bindLocalDataSource(
        localDataSourceImpl: LocalDataSourceImpl
    ): LocalDataSource

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
}