package me.buildcarter8.NotchCraft.Commands;
/*
* Copyright (c) 2011-2015, Steven Lawson
* Copyright (c) 2012-2015, Jerom van der Sar
*
* Licensed under the TotalFreedom General License (TFGL) Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* https://github.com/TotalFreedom/License/blob/master/LICENSE.md
*/
public class CantFindPlayerException extends Exception 
{

	public CantFindPlayerException()
    {
        super("Can't find player.");
    }

    public CantFindPlayerException(String msg)
    {
        super("Can't find player: " + msg);
    }
}
