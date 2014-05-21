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

package com.arcbees.hive.client.application.home;

import javax.inject.Inject;

import com.arcbees.hive.client.application.home.HomePresenter.MyView;
import com.arcbees.hive.client.resource.home.HomeResources;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import static com.google.gwt.query.client.GQuery.$;

public class HomeView extends ViewWithUiHandlers<HomeUiHandlers> implements
        MyView {
    public interface Binder extends UiBinder<Widget, HomeView> {
    }

    @UiField
    Anchor btGWTP;
    @UiField
    Anchor btJukito;
    @UiField
    Anchor btGAE;
    @UiField
    DivElement divGWTP;
    @UiField
    DivElement divGAE;
    @UiField
    DivElement divJukito;

    private final HomeResources homeResources;
    private boolean isTimerOn;
    private int productInt;
    private static int animationTopDownDuration = 500;
    private static int timerTopDownPeriod = 6000;

    private String productNavStyleName;
    private String stateAboveStyleName;
    private String stateBelowStyleName;
    private String stateTransitionStyleName;
    private String productsButtonStyleName;
    private String productsButtonOnStyleName;
    private String productsButtonOffStyleName;
    private String productsButtonLastStyleName;

    private String carrouselContainer;
    private String allCarrouselDivs;
    private String firstCarrouselDiv;

    @Inject
    HomeView(Binder uiBinder,
             HomeResources homeResources) {
        this.homeResources = homeResources;

        productNavStyleName = "." + homeResources.style().productsNav();
        stateAboveStyleName = homeResources.style().stateAbove();
        stateBelowStyleName = homeResources.style().stateBelow();
        stateTransitionStyleName = homeResources.style().stateTransition();
        productsButtonStyleName = homeResources.style().sliderProductsButton();
        productsButtonOnStyleName = homeResources.style().sliderProductsOn();
        productsButtonOffStyleName = homeResources.style().sliderProductsOff();
        productsButtonLastStyleName = homeResources.style().sliderProductsLast();

        carrouselContainer = productNavStyleName;
        allCarrouselDivs = productNavStyleName + " div";
        firstCarrouselDiv = productNavStyleName + " div:first-child";

        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void startTimer() {
        isTimerOn = true;

        Scheduler.get().scheduleFixedPeriod(new Scheduler.RepeatingCommand() {
            public boolean execute() {
                moveProductsUpward();

                return isTimerOn;
            }
        }, timerTopDownPeriod);
    }

    @Override
    public void stopTimer() {
        isTimerOn = false;
    }

    private void moveProductsUpward() {
        $(allCarrouselDivs).addClass(stateTransitionStyleName);
        $(allCarrouselDivs).addClass(stateAboveStyleName);

        Scheduler.get().scheduleFixedPeriod(new Scheduler.RepeatingCommand() {
            public boolean execute() {
                removeProductClasses();
                switchInteger();
                setEnabled(productInt);

                return false;
            }
        }, animationTopDownDuration);
    }

    private void switchInteger() {
        if ($(divGWTP).is(":first-child")) {
            productInt = 0;
        } else {
            if ($(divGAE).is(":first-child")) {
                productInt = 1;
            } else {
                productInt = 2;
            }
        }
    }

    private void removeProductClasses() {
        $(firstCarrouselDiv).appendTo(carrouselContainer);
        $(allCarrouselDivs).removeClass(stateTransitionStyleName);
        $(allCarrouselDivs).removeClass(stateAboveStyleName);
    }

    private void setEnabled(int index) {
        disableAll();

        Anchor selected = btGWTP;

        switch (index) {
            case 0:
                selected = btGWTP;
                break;
            case 1:
                selected = btGAE;
                break;
            case 2:
                selected = btJukito;
                break;
            default:
                Window.alert("wrong index: " + index);
                break;
        }

        enable(selected);
    }

    private void disableAll() {
        disableAnchor(btGWTP);
        disableAnchor(btGAE);
        disableAnchor(btJukito);
    }

    private void disableAnchor(Anchor toDisable) {
        toDisable.setStyleName(homeResources.style().sliderProductsOff());
    }

    private void enable(Anchor selected) {
        selected.setStyleName(homeResources.style().sliderProductsOn());
    }
}
