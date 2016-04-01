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
package com.github.pedrovgs.tuentitv.model;

import com.github.pedrovgs.tuentitv.ui.data.ImageInfo;

/**
 * Base class of MediaGallery feature. This class contains all the data needed by the UI to show a
 * MediaElement. This class implements ImageInfo interface to return MediaElement objects to the UI
 * layer using ImageInfo static type.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class MediaElement implements ImageInfo {

    private final String title;
    private final String imageUrl;

    public MediaElement(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getImageUrl() {
        return imageUrl;
    }
}
