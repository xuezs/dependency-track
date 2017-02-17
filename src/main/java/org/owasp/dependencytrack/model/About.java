/*
 * This file is part of Dependency-Track.
 *
 * Dependency-Track is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * Dependency-Track is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Dependency-Track. If not, see http://www.gnu.org/licenses/.
 */
package org.owasp.dependencytrack.model;

import alpine.Config;
import org.owasp.dependencycheck.utils.Settings;
import javax.inject.Singleton;
import java.io.Serializable;

@Singleton
public class About implements Serializable {

    private static final long serialVersionUID = -7573425245706188307L;

    static {
        Settings.initialize();
    }

    private static final String application = Config.getInstance().getProperty(Config.Key.APPLICATION_NAME);
    private static final String version = Config.getInstance().getProperty(Config.Key.APPLICATION_VERSION);
    private static final String timestamp = Config.getInstance().getProperty(Config.Key.APPLICATION_TIMESTAMP);
    private static final String dcApplication = Settings.getString(Settings.KEYS.APPLICATION_NAME);
    private static final String dcVersion = Settings.getString(Settings.KEYS.APPLICATION_VERSION);


    public String getApplication() {
        return application;
    }

    public String getVersion() {
        return version;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public DependencyCheck getDependencyCheck() {
        return new DependencyCheck();
    }

    private static class DependencyCheck {

        public String getApplication() {
            return dcApplication;
        }

        public String getVersion() {
            return dcVersion;
        }
    }

}