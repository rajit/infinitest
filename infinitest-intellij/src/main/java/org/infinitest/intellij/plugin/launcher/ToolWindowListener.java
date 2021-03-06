/*
 * This file is part of Infinitest.
 *
 * Copyright (C) 2010
 * "Ben Rady" <benrady@gmail.com>,
 * "Rod Coffin" <rfciii@gmail.com>,
 * "Ryan Breidenbach" <ryan.breidenbach@gmail.com>, et al.
 *
 * Infinitest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Infinitest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Infinitest.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.infinitest.intellij.plugin.launcher;

import com.intellij.openapi.util.IconLoader;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import org.infinitest.intellij.idea.window.IdeaWindowHelper;

import javax.swing.Icon;

/**
 * Created by IntelliJ IDEA.
 * User: aurelien
 * Date: 09/06/11
 * Time: 21:26
 */
public class ToolWindowListener implements PresenterListener
{
    ToolWindowManager toolWindowManager;
    String toolWindowId;

    public ToolWindowListener(ToolWindowManager toolWindowManager, String toolWindowId)
    {
        this.toolWindowManager = toolWindowManager;
        this.toolWindowId = toolWindowId;
    }

    public void testRunCompleted()
    {
        // nothing to do here
    }

    public void testRunSucceed()
    {
        editToolWindowIcon(IconLoader.getIcon(IdeaWindowHelper.SUCCESS_ICON_PATH));
    }

    public void testRunFailed()
    {
        editToolWindowIcon(IconLoader.getIcon(IdeaWindowHelper.FAILURE_ICON_PATH));
    }

    public void testRunStarted()
    {
        editToolWindowIcon(IconLoader.getIcon(IdeaWindowHelper.RUNNING_ICON_PATH));
    }

    public void testRunWaiting()
    {
        editToolWindowIcon(IconLoader.getIcon(IdeaWindowHelper.WAITING_ICON_PATH));
    }

    private void editToolWindowIcon(Icon icon)
    {
        ToolWindow toolWindow = toolWindowManager.getToolWindow(toolWindowId);
        if(toolWindow != null)
        {
            toolWindow.setIcon(icon);
        }
    }
}
