/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.mindorks.framework.mvvm.ui.feed.opensource;

import android.databinding.ObservableField;

import com.mindorks.framework.mvvm.data.model.api.OpenSourceResponse;

/**
 * Created by amitshekhar on 10/07/17.
 */

public class OpenSourceItemViewModel {

    private OpenSourceResponse.Repo mRepo;
    public ObservableField<String> imageUrl;
    public ObservableField<String> title;
    public ObservableField<String> content;

    public OpenSourceItemViewModelListener mListener;

    public OpenSourceItemViewModel(OpenSourceResponse.Repo repo, OpenSourceItemViewModelListener listener) {
        this.mRepo = repo;
        this.mListener = listener;
        imageUrl = new ObservableField<>(repo.getCoverImgUrl());
        title = new ObservableField<>(mRepo.getTitle());
        content = new ObservableField<>(mRepo.getDescription());
    }

    public void onItemClick() {
        mListener.onItemClick(mRepo.getProjectUrl());
    }

    public interface OpenSourceItemViewModelListener {
        void onItemClick(String projectUrl);
    }

}
