/*
 * Copyright (C) 2016 mc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xixicm.de.infrastructure.service;

import android.content.Context;
import android.content.Intent;

import com.xixicm.de.domain.Constants;
import com.xixicm.de.domain.base.util.LogUtils;
import com.xixicm.de.domain.interactor.SentenceFetchExecutor;

/**
 * @author mc
 */
public class ServiceSentenceFetchExecutor implements SentenceFetchExecutor {
    private static ServiceSentenceFetchExecutor sInstance;
    Context mContext;

    ServiceSentenceFetchExecutor(Context context) {
        mContext = context.getApplicationContext();
    }

    public static synchronized ServiceSentenceFetchExecutor getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new ServiceSentenceFetchExecutor(context);
        }
        return sInstance;
    }

    @Override
    public void fetchTodaysSentence(boolean manual) {
        LogUtils.v(Constants.TAG, ServiceSentenceFetchExecutor.class.getCanonicalName() + " fetchTodaysSentence");
        mContext.startService(new Intent(mContext, DEFetchService.class));
    }
}
