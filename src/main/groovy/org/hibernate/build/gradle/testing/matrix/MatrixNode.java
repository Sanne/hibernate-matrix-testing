/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2011, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.build.gradle.testing.matrix;

import java.io.File;

import org.gradle.api.Project;

import org.hibernate.build.gradle.testing.database.DatabaseProfile;

/**
 * A testing matrix node combines a database profile and a jdk (eventually) along with managing "db allocation"
 * information.
 *
 * @author Steve Ebersole
 * @author Strong Liu
 */
public class MatrixNode {
	private final DatabaseProfile databaseProfile;
	private final File baseOutputDirectory;

	@SuppressWarnings( {"ResultOfMethodCallIgnored"})
	public MatrixNode(Project project, DatabaseProfile databaseProfile) {
		this.databaseProfile = databaseProfile;

		this.baseOutputDirectory = new File( new File( project.getBuildDir(), "matrix" ), databaseProfile.getName() );
		baseOutputDirectory.mkdirs();
	}

    public String getName() {
		return databaseProfile.getName();
	}

	public DatabaseProfile getDatabaseProfile() {
		return databaseProfile;
	}

	public File getBaseOutputDirectory() {
		return baseOutputDirectory;
	}
}
