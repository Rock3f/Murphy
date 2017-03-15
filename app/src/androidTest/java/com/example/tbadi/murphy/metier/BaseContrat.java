package com.example.tbadi.murphy.metier;

import android.provider.BaseColumns;

public final class BaseContrat
{

	/**
	 * Constructeur privé afin de ne pas instancier la classe.
	 */
	private BaseContrat() {};

	/**
	 * Contenu de la table "courses".
	 */
	public static class NiveauContrat implements BaseColumns
	{
		public static final String TABLE_NIVEAU = "niveau";
		public static final String COLONNE_INTITULE = "intitule";
		public static final String COLONNE_VALIDE = "valide";
	}

	public static class PointsContrat implements BaseColumns
	{
		public static final String TABLE_POINTS = "points";
		public static final String COLONNE_NB_POINTS = "nb_points";
	}

}
