/*
 * Copyright (c) 2014 by Roler Data Transfer Services, Inc., All rights reserved.
 * This source code, and resulting software, is the confidential and proprietary information
 * ("Proprietary Information") and is the intellectual property ("Intellectual Property")
 * of Roler Data Transfer Services, Inc. ("The Company"). You shall not disclose such Proprietary Information and
 * shall use it only in accordance with the terms and conditions of any and all license
 * agreements you have entered into with The Company.
 */

package com.arcbees.website.client.application.ui;

import com.arcbees.website.client.resources.ui.CarouselResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;

import static com.google.gwt.query.client.GQuery.$;

public class Carousel extends HTMLPanel implements IsWidget {
    private static final CarouselResources RESOURCES = GWT.create(CarouselResources.class);

    public static Carousel carousel = null;
    private static Object items = null;
    private static Object itemsList = null;
    private static Integer position = 1;
    private static Integer middle = 1;

    public Carousel(String html) {
        // Set initial HTML
        super("<div class=\"" + RESOURCES.style().items() + "\">" + html + "</strong>");

        carousel = this;

        bind();
    }

    public void bind() {
        $(carousel).addClass(RESOURCES.style().carousel());
        items = $(carousel).children();

        // Find each items
        itemsList = $(items).children();

        // Add before and after elements to cycle
        for (Integer i = 1; i <= ($(itemsList).length() - 1) / 2; i++) {
            $(items).prepend($(itemsList).eq($(itemsList).length() - i).clone());
            $(items).append($(itemsList).eq(i - 1).clone());
        }

        // Rebuild the item list with the newly added items
        itemsList = $(items).children();

        generateDataPosition();

        // Add style and all to each item
        $(itemsList).each(new Function() {
            public void f(Element e) {
                $(this).addClass(RESOURCES.style().item());
                if ($(itemsList).length() % 2 == 0) {
                    $(this).css("width", 100 / $(itemsList).length() + "%");
                } else {
                    $(this).css("width", 100 / ($(itemsList).length() + 1) + "%");
                }

                $(this).click(new Function(){
                    public void f() {
                        position = Integer.parseInt($(this).attr("data-position"));
                        calculatePosition();
                    }
                });
            }
        });

        $(carousel).css("height", $(items).css("height"));

        this.calculateMiddle();
        this.calculateSizes();
    }

    public void calculateMiddle() {
        // Find middle
        if ($(itemsList).length() % 2 == 0) {
            // TODO : Even
            middle = $(itemsList).length() / 2;
        } else {
            middle = ($(itemsList).length() + 1) / 2;
            position = middle;
        }
    }

    public void calculateSizes() {
        GQuery.console.log(position);
        // Before middle
        for (Integer i = 1; i < position; i++) {
            Integer scale = 10 - (position - i);
            $(itemsList).eq(i - 1).css("transform", "scale(0." + scale + ", 0." + scale + ")");
        }

        // Middle
        $(itemsList).eq(position - 1).css("transform", "scale(1, 1)");

        // After middle
        for (Integer i = position + 1; i <= $(itemsList).length(); i++) {
            Integer scale = 10 - (i - position);
            $(itemsList).eq(i - 1).css("transform", "scale(0." + scale + ", 0." + scale + ")");
        }
    }

    public void calculatePosition() {
        if (! position.equals(middle)) {
            if (position < middle) {
                for (Integer i = 1; i <= middle - position; i++) {
                    $(items).prepend($(itemsList).last());
                    $(items).find("div").first().css("width", "0px");
                    $(items).find("div").first().animate("width: " + (100 / ($(itemsList).length() + 1)) + "%", 200);
                    itemsList = $(items).children();
                }
            } else {
                for (Integer i = 1; i <= position - middle; i++) {
                    $(items).append($(itemsList).first());
                    $(items).find("div").last().css("width", "0px");
                    $(items).find("div").last().animate("width: " + (100 / ($(itemsList).length() + 1)) + "%", 200);
                    itemsList = $(items).children();
                }
            }

            generateDataPosition();
            calculateSizes();
        }
    }

    public void generateDataPosition() {
        position = 1;
        $(itemsList).each(new Function() {
            public void f(Element e) {
                $(this).attr("data-position", position);
                position++;
            }
        });
        position = middle;
    }
}
