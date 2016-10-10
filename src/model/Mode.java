package model;

import java.util.ArrayList;
/**
 * Classe d'objet metier MODE
 * @author xavier
 * 
 */
public class Mode {
	/**
	 * Identifiant de la mode
	 */
	private int id;
	/**
	 * Nom de la mode
	 */
	private String name;
	/**
	 * Liste statique de toutes les modes
	 */
	public static ArrayList<Mode> allTheModes = new ArrayList<Mode>();
	
	/**
	 * Constructeur de la classe Mode
	 * @param id identifiant de la nouvelle mode
	 * @param name nom de la nouvelle mode
	 */
	public Mode(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		allTheModes.add(this);
	}
	/**
	 * Accesseur en lecture sur l'identifiant de la mode
	 * @return l'identifiant de la mode
	 */
	public int getId(){
		return id;
	}
	
	/**
	 * Accesseur en lecture sur le nom de la mode
	 * @return le nom de la mode
	 */
	public String getName() {
		return name;
	}
	/**
	 * M�thode permettant de rechercher parmi toutes les modes
	 * celle ayant un identifiant correspondant � celui pass� en param�tre
	 * @param id l'identifiant � rechercher
	 * @return la Mode correspondante
	 */
	public static Mode getModeById(int id){
		Mode found = null;
		for(Mode f : Mode.allTheModes){
			if(f.getId()==id)
				found=f;
		}
		return found;
	}
	/**
	 * M�thode permettant de rechercher parmi toutes les modes
	 * celle ayant un nom correspondant � celui pass� en param�tre
	 * @param name le nom � rechercher
	 * @return la Mode correspondante
	 */
	public static Mode getModeByName(String name) {
		Mode found = null;
		for(Mode f : Mode.allTheModes){
			if(f.getName().equals(name))
				found=f;
		}
		return found;
	}

}

