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
package com.github.pedrovgs.tuentitv.ui.navigator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.github.pedrovgs.tuentitv.di.ActivityContext;
import com.github.pedrovgs.tuentitv.ui.activity.DetailActivity;
import com.github.pedrovgs.tuentitv.ui.activity.LoadingActivity;
import com.github.pedrovgs.tuentitv.ui.activity.MainActivity;
import com.github.pedrovgs.tuentitv.ui.activity.SearchActivity;
import com.github.pedrovgs.tuentitv.ui.activity.ShowImageActivity;
import javax.inject.Inject;

/**
 * Class created to implement Application navigation based on activities as is explained in
 * https://github.com/pedrovgs/EffectiveAndroidUI sample project.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class Navigator {

  private final Activity context;

  @Inject public Navigator(@ActivityContext Context context) {
    this.context = (Activity) context;
  }

  public void openMainView() {
    Intent intent = generateBaseIntent(MainActivity.class);
    startActivity(intent);
  }

  public void openLoadingView() {
    Intent intent = generateBaseIntent(LoadingActivity.class);
    startActivity(intent);
  }

  public void openSearchView() {
    Intent intent = generateBaseIntent(SearchActivity.class);
    startActivity(intent);
  }

  public void openDetailView(String id) {
    Intent intent = generateBaseIntent(DetailActivity.class);
    intent.putExtra(DetailActivity.ID_EXTRA, id);
    startActivity(intent);
  }

  public void openImageView(String imageUrl) {
    Intent intent = generateBaseIntent(ShowImageActivity.class);
    intent.putExtra(ShowImageActivity.IMAGE_URL_EXTRA, imageUrl);
    startActivity(intent);
  }

  private Intent generateBaseIntent(Class clazz) {
    return new Intent(context, clazz);
  }

  private void startActivity(Intent intent) {
    context.startActivity(intent);
  }
}
