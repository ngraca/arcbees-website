/*
 * Copyright 2010 ArcBees Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.arcbees.hive.client.application.common;

import com.google.gwt.i18n.client.LocaleInfo;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

public class HeaderPresenter extends PresenterWidget<HeaderPresenter.MyView> implements HeaderUiHandlers {
    public interface MyView extends View {
        void showEnglishHyperlink();

        void showFrenchHyperlink();
    }

    private final PlaceManager placeManager;

    @Inject
    public HeaderPresenter(final EventBus eventBus, final MyView view, final PlaceManager placeManager) {
        super(eventBus, view);

        this.placeManager = placeManager;
    }

    @Override
    protected void onBind() {
        super.onBind();

        LocaleInfo localeInfo = LocaleInfo.getCurrentLocale();
        String localeName = localeInfo.getLocaleName();

        if (localeName.equals("fr")) {
            getView().showEnglishHyperlink();
        } else {
            getView().showFrenchHyperlink();
        }
    }

    @Override
    public void showHome() {
        placeManager.revealDefaultPlace();
    }
}