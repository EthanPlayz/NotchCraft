package me.buildcarter8.NotchCraft.Commands;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandPermissions
{
StaffLevel level();
boolean blockHostConsole() default false;
}