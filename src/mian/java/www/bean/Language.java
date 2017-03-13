package www.bean;

public class Language {
	private int language_id;
	private String name;
	private String language_update;
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage_update() {
		return language_update;
	}
	public void setLanguage_update(String language_update) {
		this.language_update = language_update;
	}
	@Override
	public String toString() {
		return "Language [language_id=" + language_id + ", name=" + name + ", language_update=" + language_update + "]";
	}
	public Language(int language_id, String name, String language_update) {
		super();
		this.language_id = language_id;
		this.name = name;
		this.language_update = language_update;
	}
	public Language() {
		super();
	}
	

}
