package bbs.domain.internal.user.model

import org.joda.time.chrono.AssembledChronology.Fields

trait UserFields extends{
  val role: UserRole
  val username: String
  val email: String
  val slackName: String
  val password: String
}
