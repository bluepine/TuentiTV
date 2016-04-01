/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pedrovgs.tuentitv.presenter;

import com.github.pedrovgs.tuentitv.R;
import com.github.pedrovgs.tuentitv.model.MediaElement;
import com.github.pedrovgs.tuentitv.model.MediaGallery;
import com.github.pedrovgs.tuentitv.ui.data.CardInfo;
import com.github.pedrovgs.tuentitv.ui.data.IconInfo;
import com.github.pedrovgs.tuentitv.ui.data.ImageInfo;
import com.github.pedrovgs.tuentitv.ui.navigator.Navigator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

/**
 * Class created to work as main view presenter. This presenter has all the responsibility related
 * to the main view presentation logic: obtain a list of favorite contacts, obtain a list of recent
 * conversations, show a list of all user's contacts sorted alphabetically.
 * <p/>
 * Main collaborators of this class ar Accounts, Agenda, MediaGallery and Chat. Collaborators
 * needed
 * to perform all the business/presentation logic related to this view.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class MainPresenter {

    private final MediaGallery mediaGallery;
    private final Navigator navigator;

    private View view;

    @Inject
    public MainPresenter(MediaGallery mediaGallery, Navigator navigator) {
        this.mediaGallery = mediaGallery;
        this.navigator = navigator;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void loadData() {
        view.showDefaultBackground();
//    List<CardInfo> favorites = getFavoriteContacts();
//    List<CardInfo> conversations = getConversations();
//    List<CardInfo> contacts = getAllContacts();
        List<ImageInfo> mediaElements = getAllMediaElements();
        List<IconInfo> preferences = getPreferences();
        view.showMainInformation(mediaElements, preferences);
    }

    public void onCardInfoSelected(CardInfo cardInfo) {
        if (cardInfo != null) {
            view.updateBackground(cardInfo.getSecondaryImage());
        } else {
            view.showDefaultBackground();
        }
    }

    public void onCardInfoClicked(CardInfo item) {
        view.cancelPendingBackgroundUpdates();
        navigator.openDetailView(item.getId());
    }

    public void onImageInfoSelected(ImageInfo imageInfo) {
        if (imageInfo != null) {
            view.updateBackground(imageInfo.getImageUrl());
        }
    }

    public void onImageInfoClicked(ImageInfo item) {
        navigator.openImageView(item.getImageUrl());
    }

    public void onPreferencesSelected() {
        view.showDefaultBackground();
    }

    public void onSearchIconClicked() {
        navigator.openSearchView();
    }

    public void logout() {
        view.closeView();
    }

    private List<ImageInfo> getAllMediaElements() {
        List<MediaElement> lastMediaElements = mediaGallery.getLatestMediaElements();
        return new ArrayList<ImageInfo>(lastMediaElements);
    }

    private List<IconInfo> getPreferences() {
        List<IconInfo> preferences = new LinkedList<IconInfo>();
        preferences.add(new IconInfo(R.string.change_pattern, R.drawable.icn_settings_change_pattern));
        preferences.add(new IconInfo(R.string.account, R.drawable.icn_settings_account));
        preferences.add(new IconInfo(R.string.settings, R.drawable.icn_settings));
        preferences.add(new IconInfo(R.string.close_session, R.drawable.icn_settings_log_out));
        return preferences;
    }

    public interface View {

        void updateBackground(String imageUrl);

        void showMainInformation(List<ImageInfo> mediaElements, List<IconInfo> preferences);

        void showDefaultBackground();

        void closeView();

        void cancelPendingBackgroundUpdates();
    }
}
