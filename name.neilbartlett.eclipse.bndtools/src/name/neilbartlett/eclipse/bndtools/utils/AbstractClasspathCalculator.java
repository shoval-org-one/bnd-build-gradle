/*******************************************************************************
 * Copyright (c) 2010 Neil Bartlett.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Neil Bartlett - initial API and implementation
 *******************************************************************************/
package name.neilbartlett.eclipse.bndtools.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;

public abstract class AbstractClasspathCalculator implements IClasspathCalculator {
	protected static List<File> pathsToFiles(IWorkspaceRoot root, List<IPath> paths) {
		List<File> result = new ArrayList<File>(paths.size());
		for (IPath path : paths) {
			if(path.isAbsolute()) {
				result.add(path.toFile());
			} else {
				IResource resource = root.findMember(path);
				if(resource != null)
					result.add(resource.getLocation().toFile());
			}
		}
		return result;
	}
}
