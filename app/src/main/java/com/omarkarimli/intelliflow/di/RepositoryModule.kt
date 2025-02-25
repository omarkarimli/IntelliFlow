package com.omarkarimli.intelliflow.di

import com.omarkarimli.intelliflow.data.repository.IntelliFlowRepositoryImpl
import com.omarkarimli.intelliflow.domain.repository.IntelliFlowRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepositoryModule(
        repositoryImpl: IntelliFlowRepositoryImpl
    ): IntelliFlowRepository
}