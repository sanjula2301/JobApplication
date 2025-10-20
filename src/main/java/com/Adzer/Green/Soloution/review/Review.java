package com.Adzer.Green.Soloution.review;

import com.Adzer.Green.Soloution.company.Company;
import jakarta.persistence.*;

@Entity
@Table(name = "review_table")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String title;
    private String description;
    private double rating;
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    public Review() {
    }

    public Review(Long reviewId, String title, String description, double rating, Company company) {
        this.reviewId = reviewId;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.company = company;
    }
    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", company=" + company +
                '}';
    }
}
