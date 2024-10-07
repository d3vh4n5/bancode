package com.bancodo.helpers;

import com.bancodo.classes.FileManager;
import com.bancodo.menues.WelcomeMenu;
import com.bancodo.models.*;

public class ApplicationBootstrapper {
    public static void bootstrap() {
        FileManager.directoryExists();
        User.generateDemoFiles();
        WelcomeMenu.menu();
    }
}
