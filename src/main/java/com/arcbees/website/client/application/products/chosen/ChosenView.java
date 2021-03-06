/**
 * Copyright 2015 ArcBees Inc.
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

package com.arcbees.website.client.application.products.chosen;

import com.arcbees.chosen.client.Chosen;
import com.arcbees.chosen.client.ChosenOptions;
import com.arcbees.website.client.resources.PageProductChosenResources;
import com.google.gwt.dom.client.SelectElement;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import static com.google.gwt.query.client.GQuery.$;

public class ChosenView extends ViewImpl implements ChosenPresenter.MyView, AttachEvent.Handler {
    interface Binder extends UiBinder<Widget, ChosenView> {
    }

    @UiField
    SelectElement selectToEnhance;

    private final PageProductChosenResources pageProductChosenResources;

    @Inject
    ChosenView(
            PageProductChosenResources pageProductChosenResources,
            Binder binder) {
        this.pageProductChosenResources = pageProductChosenResources;
        initWidget(binder.createAndBindUi(this));

        asWidget().addAttachHandler(this);
    }

    @Override
    public void onAttachOrDetach(AttachEvent event) {
        if (event.isAttached()) {
            ChosenOptions options = new ChosenOptions().setResources(pageProductChosenResources);
            $(selectToEnhance).as(Chosen.Chosen).chosen(options);
        }
    }
}
