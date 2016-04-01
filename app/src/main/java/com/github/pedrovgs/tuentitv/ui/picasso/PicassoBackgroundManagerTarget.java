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
package com.github.pedrovgs.tuentitv.ui.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.app.BackgroundManager;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Picasso target implementation for updating background images inside leanback fragments.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class PicassoBackgroundManagerTarget implements Target {
    BackgroundManager backgroundManager;

    public PicassoBackgroundManagerTarget(BackgroundManager backgroundManager) {
        this.backgroundManager = backgroundManager;
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        this.backgroundManager.setBitmap(bitmap);
    }

    @Override
    public void onBitmapFailed(Drawable drawable) {
        this.backgroundManager.setDrawable(drawable);
    }

    @Override
    public void onPrepareLoad(Drawable drawable) {
        //Empty. We don't want to support placeholders.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PicassoBackgroundManagerTarget that = (PicassoBackgroundManagerTarget) o;

        if (!backgroundManager.equals(that.backgroundManager)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return backgroundManager.hashCode();
    }
}
