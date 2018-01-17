package de.mploed.ddd.scoring.calculation;

import de.mploed.ddd.scoring.ApplicationNumber;

public class ScoringResultAggregate {
	ScoringResultRootEntity rootEntity;
	private ScoringResultAggregate(Builder builder) {
		this.rootEntity = new ScoringResultRootEntity(builder.applicationNumber,
													builder.applicantScoringResult,
													builder.financialSituationScoringResult,
													builder.agencyScoringResult,
													builder.noGoCriteriaPresent);
	}

	public String getScoreColor() {
		return this.rootEntity.getOverallScoringResult().getColor().toString();
	}

	public int getScorePoints() {
		return this.rootEntity.getOverallScoringResult().getPoints();
	}

	public static class Builder {
		private final ApplicationNumber applicationNumber;
		private int applicantScoringResult;
		private int financialSituationScoringResult;
		private int agencyScoringResult;
		private boolean noGoCriteriaPresent;

		public Builder(ApplicationNumber applicationNumber) {
			this.applicationNumber = applicationNumber;
		}

		public Builder applicantScoring(int applicantScoringResult) {
			this.applicantScoringResult = applicantScoringResult;
			return this;
		}

		public Builder financialSituationScoring(int financialSituationScoringResult) {
			this.financialSituationScoringResult = financialSituationScoringResult;
			return this;
		}

		public Builder agencyScoring(int agencyScoringResult) {
			this.agencyScoringResult = agencyScoringResult;
			return this;
		}

		public Builder noGoCriteria(boolean noGoCriteriaPresent) {
			this.noGoCriteriaPresent = noGoCriteriaPresent;
			return this;
		}

		public ScoringResultAggregate build() {
			return new ScoringResultAggregate(this);
		}


	}

}
