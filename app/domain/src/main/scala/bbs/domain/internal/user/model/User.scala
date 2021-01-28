package bbs.domain.internal.user.model

import bbs.utility.model.Entity


case class User(identifier: UserId,
                role: UserRole,
                username: String,
                email: String,
                slackName: String,
                password: String
               ) extends Entity[UserId] with UserFields{}


