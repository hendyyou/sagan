package org.springframework.site.domain.team;

import org.hibernate.annotations.Type;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Entity
public class MemberProfile {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = true)
	private String name;

	@Column(nullable = true)
	private String location;

	@Column(nullable = true)
	private String bio;

	@Column(nullable = true)
	private String avatarUrl;

	@Column(nullable = true)
	private String gravatarEmail;

	@Column(nullable = true)
	private String githubUsername;

	@Column(nullable = true)
	private String speakerdeckUsername;

	@Column(nullable = true)
	private String twitterUsername;

	@Column(nullable = true)
	private String lanyrdUsername;

	@Column(nullable = false)
	private String memberId;

	@Column
	private GeoLocation geoLocation;

	@Column
	@Type(type="text")
	private String videoEmbeds;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getGithubUsername() {
		return githubUsername;
	}

	public void setGithubUsername(String githubUsername) {
		this.githubUsername = githubUsername;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getGravatarEmail() {
		return gravatarEmail;
	}

	public void setGravatarEmail(String gravatarEmail) {
		this.gravatarEmail = gravatarEmail;
	}

	public String getSpeakerdeckUsername() {
		return speakerdeckUsername;
	}

	public void setSpeakerdeckUsername(String speakerdeckUsername) {
		this.speakerdeckUsername = speakerdeckUsername;
	}

	public String getTwitterUsername() {
		return twitterUsername;
	}

	public void setTwitterUsername(String twitterUsername) {
		this.twitterUsername = twitterUsername;
	}

	public String getLanyrdUsername() {
		return lanyrdUsername;
	}

	public void setLanyrdUsername(String lanyrdUsername) {
		this.lanyrdUsername = lanyrdUsername;
	}

	public String getFullName() {
		return name == null ? getMemberId() : name;
	}

	public Link getTwitterLink() {
		if (StringUtils.isEmpty(getTwitterUsername())) {
			return null;
		}
		return new Link(String.format("http://twitter.com/%s", getTwitterUsername()), "@" + getTwitterUsername());
	}

	public Link getSpeakerdeckLink() {
		if (StringUtils.isEmpty(getSpeakerdeckUsername())) {
			return null;
		}
		String pathAndHost = String.format("speakerdeck.com/%s", getSpeakerdeckUsername());
		return new Link("https://" + pathAndHost, pathAndHost);
	}

	public Link getGithubLink() {
		if (StringUtils.isEmpty(getGithubUsername())) {
			return null;
		}
		String pathAndHost = String.format("github.com/%s", getGithubUsername());
		return new Link("https://" + pathAndHost, pathAndHost);
	}

	public Link getLanyrdLink() {
		if (StringUtils.isEmpty(getLanyrdUsername())) {
			return null;
		}
		String pathAndHost = String.format("lanyrd.com/profile/%s", getLanyrdUsername());
		return new Link("https://" + pathAndHost, pathAndHost);
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	public TeamLocation getTeamLocation() {
		if (geoLocation == null) return null;
		return new TeamLocation(name, geoLocation.getLatitude(), geoLocation.getLongitude());
	}

	public String getVideoEmbeds() {
		return videoEmbeds;
	}

	public void setVideoEmbeds(String videoEmbeds) {
		this.videoEmbeds = videoEmbeds;
	}
}
