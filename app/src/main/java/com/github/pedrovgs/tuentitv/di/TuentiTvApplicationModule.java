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
package com.github.pedrovgs.tuentitv.di;

import com.github.pedrovgs.tuentitv.model.MediaGallery;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module created to provide main module dependencies. Every dependency provided here is
 * going to be in the application graph.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */

@Module(library = true) public class TuentiTvApplicationModule {

  @Provides @Singleton MediaGallery provideMediaGalery() {
    return new MediaGallery();
  }
}
