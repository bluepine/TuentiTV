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
package com.github.pedrovgs.tuentitv.ui.data;

/**
 * Class created to show information related to the user interface where that items contains just a
 * title and one icon.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class IconInfo {

    private final int title;
    private final int iconId;

    public IconInfo(int title, int iconId) {
        this.title = title;
        this.iconId = iconId;
    }

    public int getTitle() {
        return title;
    }

    public int getIconId() {
        return iconId;
    }
}
