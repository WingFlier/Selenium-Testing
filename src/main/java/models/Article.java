package models;

/**
 * Created by Tiko on 5/13/2020.
 */

public class Article
{
    private String category;
    private String title;
    private String url;

    public Article()
    {
    }

    public Article(String category, String title, String url)
    {
        this.category = category;
        this.title = title;
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "Article{" +
                "category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
}
